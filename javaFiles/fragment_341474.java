8           Terms termVector = reader.getTermVector(docNum, "contents");
9           TermsEnum itr = termVector.iterator();
10          BytesRef term = null;
11          PostingsEnum postings = null;
12          while((term = itr.next()) != null){
13              try{
14                  String termText = term.utf8ToString();
15                  postings = itr.postings(postings, PostingsEnum.FREQS);
16                  int freq = postings.freq();
17
18
19                  System.out.println("doc:" + docNum + ", term: " + termText + ", termFreq = " + freq);
20              } catch(Exception e){
21                  System.out.println(e);
22              }
23          }