Collections.sort(a2, 
                    Collections.reverseOrder(new Comparator<String>() {
                        @Override
                        public int compare(String s1, String s2) {
                            String[] d1 = s1.split(",");
                            String[] d2 = s2.split(",");
                            return Double.compare(Double.parseDouble(d1[d1.length-1]), 
                                                  Double.parseDouble(d2[d2.length-1]));
                        }
                    }));