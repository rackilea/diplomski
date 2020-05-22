List<Detail> allDetails = new LinkedList<Detail>();
                while(rs.next()) {

                    String a = rs.getString("weight");
                    String b = rs.getString("note_state");
                    String c = rs.getString("dm_state");
                    allDetail.add(new Detail (a, b, c));
                }