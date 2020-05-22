//hashing buslineIDs and distributing to correct Brokers
            int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0;
            for (int i = 0; i < topics.size(); i++) {
                String tempHash = Broker.simpleHashFunc(topics.get(i).getBusLine().getBuslineId());
                if (tempHash.compareTo(hashedBrokers.get(0)) == -1) {
                    counter1++;
                    //add responsibility line
                } else if (tempHash.compareTo(hashedBrokers.get(1)) == -1) {
                    counter2++;
                } else if (tempHash.compareTo(hashedBrokers.get(2)) == -1) {
                    counter3++;
                } else {
                    counter4++;
                    BigInteger tempHashBig = new BigInteger(tempHash, 32);
                    //System.out.println(tempHashBig);
                    if (tempHashBig.mod(BigInteger.valueOf(hashedBrokers.size())).equals(BigInteger.valueOf(0))) {
                        counter1++;
                    } else if (tempHashBig.mod(BigInteger.valueOf(hashedBrokers.size())).equals(BigInteger.valueOf(1))) {
                        counter2++;
                    } else if (tempHashBig.mod(BigInteger.valueOf(hashedBrokers.size())).equals(BigInteger.valueOf(2))) {
                        counter3++;
                    }

                }


            }