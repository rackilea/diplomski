if(method.getName().equals(iMethod.getMethodname())){

                          /**
                           * cheking whether the length of the parameter are equal
                           */
                        if(method.getParameterTypes().length==iMethod.getParam().length){

                            /**
                             * getting the fully qualified name of the selected method paramater value
                             */
                            Class<?>[] paramvalue=method.getParameterTypes();

                            for(int p=0;p<paramvalue.length;p++){

                                /**
                                 * checking whether teh parameter are same for loading teh datastore
                                 */
                                if(paramvalue[p].getSimpleName().equals(temp)){

                                    String fullyqualifiedname=paramvalue[p].getName();


                                }

                            }
                        }

                    }
             }