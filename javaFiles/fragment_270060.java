final NaturalLanguageUnderstanding understanding =
  new NaturalLanguageUnderstanding(
    NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
understanding.setUsernameAndPassword(serviceUsername, servicePassword);
understanding.setEndPoint(url);
understanding.setDefaultHeaders(getDefaultHeaders());

final String testString =
  "In remote corners of the world, citizens are demanding respect"
    + " for the dignity of all people no matter their gender, or race, or religion, or disability,"
    + " or sexual orientation, and those who deny others dignity are subject to public reproach."
    + " An explosion of social media has given ordinary people more ways to express themselves,"
    + " and has raised people's expectations for those of us in power. Indeed, our international"
    + " order has been so successful that we take it as a given that great powers no longer"
    + " fight world wars; that the end of the Cold War lifted the shadow of nuclear Armageddon;"
    + " that the battlefields of Europe have been replaced by peaceful union; that China and India"
    + " remain on a path of remarkable growth.";
final ConceptsOptions concepts =
  new ConceptsOptions.Builder().limit(5).build();

final Features features =
  new Features.Builder().concepts(concepts).build();
final AnalyzeOptions parameters = new AnalyzeOptions.Builder()
  .text(testString).features(features).returnAnalyzedText(true).build();

final AnalysisResults results =
  understanding.analyze(parameters).execute();
System.out.println(results);