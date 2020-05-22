@Unroll
def 'some test for #fileName and #result'() {
  expect:
  File f = new File( fileName )
  myclass.deleteImages()
  f.exists() == result

  where:
      fileName        | result
    'imageFile.JPG'   | false
    'imageFile.TIF'   | false
    'videoFile.MKV'   | true
    .....
}