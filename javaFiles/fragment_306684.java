String text = null
new File(relativePath).withInputStream { istream ->
    text = IOUtils.toString(istream);
} catch (IOException e) {
    e.printStackTrace();
}
return text