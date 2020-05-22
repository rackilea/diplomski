String[] sampleArray = s.split(" ");
                if (sampleArray != null)
                {
                    String sample = sampleArray[sampleArray.length - 1];

                    if (sampleList.contains(sample))
                    {
                        stringBuilder.append(sample + "\n");
                    }
                }