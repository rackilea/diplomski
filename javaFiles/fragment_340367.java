class MyComparator2 implements Comparator<OutputSentence>{
    public int compare(OutputSentence s1, OutputSentence s2) {
        // TODO Auto-generated method stub
        int result = Integer.valueOf(s1.getTokenId()).compareTo(s2.getTokenId());
        if(result==0)
        {
            int result1 = Double.valueOf(s2.getSimilarityScore()).compareTo(s1.getSimilarityScore());
            return result1;
        }
        else
            return result;
    }
}