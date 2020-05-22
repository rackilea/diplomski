package de.scrum_master.stackoverflow

import org.apache.commons.validator.routines.UrlValidator
import spock.lang.Specification

class DownloadFileSpec extends Specification {
  def "Should return buffered reader for url for gzip csv file"() {
    given:
    String url = new File("src/test/resources/test_data.csv.gz").toURI().toURL()
    def downloadFile = new DownloadFile()
    downloadFile.urlValidator = Mock(UrlValidator) {
      isValid(_) >> true
    }

    when:
    def bufferedReader = downloadFile.downloadGzipCsvFile(url)

    then:
    bufferedReader.ready()
  }
}