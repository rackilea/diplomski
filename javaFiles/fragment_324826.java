case 2:                     
                    try{
                        File integerFile = new File("Integers.txt");                        
                        Scanner inFile = new Scanner(integerFile);
                        //int size = inFile.nextInt();
                        List<Integer> listIntegers = new ArrayList<>();
                        /*for(int i = 0; i < upperBound; i++) {
                            sum.add(i);
                        }
                        // necessary to convert back to Integer[]
                        Integer[] sumArray = sum.toArray(new Integer[0]);*/
                        //int[] arrIntegers = new int[(int)integerFile.length()];
                        int i = 0;
                        while(inFile.hasNextInt()){
                            //arrIntegers[i++] = inFile.nextInt();
                            i = inFile.nextInt();
                            listIntegers.add(i);
                            i++;
                            /*inFile.next();
                            if(inFile.hasNextInt()){

                            }*/
                        }
                        Integer[] arrIntegers = listIntegers.toArray(new Integer[0]);
                        int sum = 0;
                        for(int j = 0; j < arrIntegers.length; j++){
                            System.out.println(arrIntegers[j]);
                            sum += arrIntegers[j];
                        }
                        System.out.println("\nSum of the integers present in Integers.txt is " + sum);

                    }catch(Exception e){
                    }                       
                    break;