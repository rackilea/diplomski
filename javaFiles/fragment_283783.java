class timesTableFrame ... {
    generateArray generatedArray = new generatedArray();

    public void actionPerformed(ActionEvent e){
        int answer = generatedArray.getAnswer();
    }

    class generateArray{
        private int answer;

        public int getAnswer(){
             return answer;
        }
    }
}