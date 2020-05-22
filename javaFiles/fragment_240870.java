for (int i = 0; i < knowledgeD.size(); i++ ){
       if (i != 0) {
           string.append(", ");
       }
       w = knowledgeD.get(i).get(0);
       y = knowledgeD.get(i).get(1);
       string.append("{true@" +  w + ","+" " +"false@"  + w.complement() + "}" + "@" + y);
}