for (int i = 0; i < parenPart.size(); i++) {
//parenPart.size() not parenPart.size()-1
                        if (parenPart.get(i) == '}' && parenPart.get(i-1) == '{') {
                            parenPart.remove(i);
                            parenPart.remove(i-1);
                            i = i - 2;

                        } else if (parenPart.get(i) == ']' && parenPart.get(i-1) == '[') {
                            parenPart.remove(i);
                            parenPart.remove(i-1);
                            i = i - 2;
                            continue;
                        } else if (parenPart.get(i) == ')' && parenPart.get(i-1) == '(') {
                            parenPart.remove(i);
                            parenPart.remove(i-1);
                            i = i - 2;
                            continue;
                        } else {

                        }

                    }
                    //out of the for loop
                    if(parenPart.size()== 0) {
                        System.out.println("CORRECT");
                    }else {
                        System.out.println("INCORRECT:: TOKENS DON'T MATCH UP");
                    }