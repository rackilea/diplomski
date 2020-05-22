configurations{ xslt }
dependencies {
    xslt    'net.sf.saxon:saxon:8.7'
}
task generateReport << {
    File reportDir=new File("${projectDir}/HTML_Reports")
    if(reportDir.exists()){
        reportDir.deleteDir()
    }
    reportDir.mkdir()

   File emailreport=new File("${projectDir}/emailable-report.html")
   // Write some script to remove DOCTYPE from html file before running xslt.

    ant.xslt(in: "${testReportDir.absolutePath}/emailable-report.html",
             style: "${projectDir.absolutePath}/merge_html.xsl",
             out: "${reportDir.absolutePath}/index.html",
             classpath: configurations.xslt.asPath) {
            param(name: 'failedxml.outputDir', expression:  "${projectDir.absolutePath}/failedtest.xml")
        }