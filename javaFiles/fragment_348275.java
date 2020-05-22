List<Images> imgList = new ArrayList<Images>();
while(rs.next()){
       Images img = new Images(rs.getBytes("questionDesc"));
       imgList.add(img);
       imageQuestion = new ImageIcon(img);
       lblQuestionDesc.setIcon(imageQuestion);
}