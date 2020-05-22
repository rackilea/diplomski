@Service
public class UploadingService
{

    @Autowired
    private QuestionRepository questionRepository;

    public ReturnFormat uploadBulkMCQ(long answer_type, long subject_id, long chapter_id, long grade_id, MultipartFile multipartFile)
    {
        ReturnFormat rf = new ReturnFormat();
        SuccessErrorList selist = new SuccessErrorList();
        try
        {
            File file = convertMultiPartToFile( multipartFile );

            try (Reader reader = new FileReader( file ))
            {
                CsvToBean<McqUploadingFormat> csvToBean = new CsvToBeanBuilder<McqUploadingFormat>( reader )
                        .withType( McqUploadingFormat.class )
                        .withIgnoreLeadingWhiteSpace( true )
                        .build();

                List<McqUploadingFormat> _questionList = csvToBean.parse();
                List<Question> questionList = new ArrayList<>();

                List<McqUploadingFormat> successList = new ArrayList<>();
                List<McqUploadingFormat> errorList = new ArrayList<>();

                for ( McqUploadingFormat _question : _questionList )
                {
                    Question question = new Question();
                    question.setChapterId( chapter_id );
                    question.setAnswerTypeId( answer_type );
                    question.setSubjectId( subject_id );
                    question.setCreatedBy( _question.getCreated_by() );
                    question.setDifficultyLevel( Integer.parseInt( _question.getDifficulty_level() ) );
                    question.setMultipleAnswers( _question.getMultiple_answers().equals( "1" ) );
                    question.setQuestion( _question.getQuestion() );

                    List<Answer> answers = new ArrayList<>();

                    int i;

                    for ( String a1 : Arrays.asList( _question.getAnswers().split( ";" ) ) )
                    {
                        Answer _answer = new Answer();
                        _answer.setAnswerQuestion( question );
                        i = 0;
                        for ( String a2 : Arrays.asList( a1.split( ":" ) ) )
                        {
                            if ( i == 0 )
                            {
                                _answer.setAnswer( a2 );
                            }
                            else
                            {
                                _answer.setCorrect( a2.equalsIgnoreCase( "Yes" ) || a2.equalsIgnoreCase( "1" ) );
                            }
                            i++;
                        }
                        answers.add( _answer );
                    }
                    question.setAnswers( answers );
                    questionList.add( question );
                    successList.add( _question );

                    //add validations for error list
                }

                try
                {
                    questionRepository.save( questionList );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }

                selist.setSuccessList( successList );
                selist.setErrorList( errorList );

                rf.setStatus( ReturnFormat.Status.SUCCESS );
                rf.setMessage( "Successfully inserted" );
                rf.setData( selist );

            }
        }
        catch ( Exception e )
        {
            rf.setStatus( ReturnFormat.Status.ERROR );
            rf.setMessage( "Exception Occured" );
            e.printStackTrace();
        }

        return rf;
    }

    private File convertMultiPartToFile( MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

    private void saveQuestion( Question question )
    {
        for ( Answer answer : question.getAnswers() )
        {
            answer.setAnswerQuestion( question );
        }
        questionRepository.save( question );
    }

}