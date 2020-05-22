@SupportedAnnotationTypes( { "my.own.annotation.GenerateDTOConstants" } )
@SupportedSourceVersion( SourceVersion.RELEASE_6 )
public class DTOConstantAnnotationProcessor extends AbstractProcessor {

    private static final Logger LOG = LoggerFactory
            .getLogger( DTOConstantAnnotationProcessor.class );

    private static final String ASPECT_POSTFIX = ".aj";


    @Override
    public boolean process( Set<? extends TypeElement> annotations, RoundEnvironment roundEnv ) {

        DTOConstantElementVisitor visitor = new DTOConstantElementVisitor();
        for( TypeElement element : annotations ) {

            Set<? extends Element> annotatedClasses = roundEnv.getElementsAnnotatedWith( element );

            for( Element dto : annotatedClasses ) {
                generateAspect( visitor, dto );
            }
        }

        return true;

    }

    /**
     * @param visitor
     * @param dto
     */
    private void generateAspect( DTOConstantElementVisitor visitor, Element dto ) {
        dto.accept( visitor, null );
        LOG.info( "Generating aspect for " + dto.getSimpleName() );

        Filer filer = this.processingEnv.getFiler();
        try {

            String fileName = visitor.getFileName() + ASPECT_POSTFIX;
            String pkg = visitor.getPkg();

            FileObject aspectFile = filer.createResource( StandardLocation.SOURCE_OUTPUT, pkg,
                    fileName );

            Writer writer = aspectFile.openWriter();
            LOG.info( "writing aspect content into file" );
            writer.write( visitor.getFileContent() );

            writer.close();
            LOG.info( "Aspect generated for " + visitor.getFileName() );
        }
        catch( IOException e ) {
            e.printStackTrace();
            throw new java.lang.RuntimeException( e );
        }
    }
}