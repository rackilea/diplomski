@Test
    public void testScan(){
        assertEquals(Collections.emptyList(), scanLBrace("x"));
        assertEquals(Collections.emptyList(), scanLBrace("{{"));
        assertEquals(Arrays.asList("{"), scanLBrace("{"));
        assertEquals(Arrays.asList("{", "{"), scanLBrace("{ {"));
    }


     List<String> scanLBrace(String text){
        List<String> result = new ArrayList<>();
        Scanner s = new Scanner(text);
        while (s.hasNext(Pattern.quote("{")))
        {
            result.add(s.next());
        }
        return result;
    }