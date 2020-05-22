if(methodType == MethodType.Retrieve_Vulnerability_info)
                                {
                                    String scan_vuln_title= json2.get("title").toString();
                                    String scan_vuln_severityScore = json2.get("severityScore").toString();
                                    String scan_vuln_publishe_date = json2.get("published").toString();

                                    String scan_vuln_descr = json2.get("description").toString();
                                    JSONObject json3 = (JSONObject) parser.parse(scan_vuln_descr);
                                    String description_as_TEXT = json3.get("text").toString();

                                    splunkdata.getScan().getList_of_found_Vulnerabilties().get(Vulnerability_id).setSeverityScore(scan_vuln_severityScore);
                                    splunkdata.getScan().getList_of_found_Vulnerabilties().get(Vulnerability_id).setVulnerability_title(scan_vuln_title);
                                    splunkdata.getScan().getList_of_found_Vulnerabilties().get(Vulnerability_id).setPublished_date(scan_vuln_publishe_date);
                                    splunkdata.getScan().getList_of_found_Vulnerabilties().get(Vulnerability_id).setDescription(description_as_TEXT);
                                    System.out.print("\n Rapid7 : Successful GET,  vulnerabilities info of : "+ scan_vuln_title + " were retrieved" );
                                }