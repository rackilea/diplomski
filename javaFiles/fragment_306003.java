String text = textArea_1.getText();
                        int startIndex = textArea_1.getLineStartOffset(i11);
                        int endIndex = textArea_1.getLineEndOffset(i11);
                        String myString = text.substring(startIndex, endIndex);
                        for(int i1 = 0; i1 < myString.length(); i1++){
                            if(Character.isWhitespace(myString.charAt(i1))){
                                startIndex++;

                            }
                         if(!Character.isWhitespace(myString.charAt(i1))){
                                startIndex = startIndex+0;;
                                break;
                            }


                        }

                        String myString2 = text.substring(startIndex, endIndex);
                        String [] javaWords = {myString2};
                        System.out.println("String to Highlight: " + myString2);
                        highLight(textArea_1, javaWords);