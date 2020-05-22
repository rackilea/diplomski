String strLine;
          while ((strLine = br2.readLine()) != null)   {
          String[] arr=strLine.split(",");

          for (int i = 0; i <arr.length; i++) {
                String v = arr[i];
                String w = arr[++i];
                double weight =Double.parseDouble(arr[++i]);
                if(S.findVertexByName(v) == false)
                {


                    S.addVertex(new Vertex(v));
                    count ++;
                }
                 if(S.findVertexByName(w) == false)
                {


                    S.addVertex(new Vertex(w));
                    count ++;
                }

                S.addEdge(S.getVertexByName(v), S.getVertexByName(w), weight);
               }             
            }