if (visual[i][j].equals("p")) {
                    System.out.println(pY + "");  //Compilation error because compiler is not sure if LV would be in initialized state.
                    pX = j;
                    pY = i;
                    System.out.println(pY + "");  //Happy compiler becuse it is sure that LV are just initialized.
                }