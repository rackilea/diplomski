out.print("<Table width=110% align=center border='1'>");
 for (int i = 0; i < cards.size(); i++) {
                    Card card = new Card();
                    card = cards.get(i);


               out.print("<tr>");
                out.print("<td><input type=hidden name=\"idcard\" ></td>");
                int idcard = card.getId();
                out.print("<tr><th>card Id</th>\n<th>Card number</th>\n <th>Attivation code</th>\n <th>Pin</th>\n <th>Amount</th>\n <th>Expiry date</th>\n <th>Select</th>\n</tr>");
                out.print("<td align=center>" + card.getId()+ "</td>");
                out.print("<td align=center>" + card.getCardNumber()+ "</td>");
                out.print("<td align=center>" + card.getAttCode()+ "</td>");
                out.print("<td align=center>" + card.getPin() + "</td>");
                out.print("<td align=center>&#8364; "+ card.getAmount() + "</td>");
                out.print("<td align=center>" + card.getExpiryMonth()+ "/" + card.getExpiryYear() + "</td>");
                out.print("<td align= center><input type=\"button\" value=\"Select\" onclick=\"exeForm(1,'CardExe.jsp',"+card.getId()+")\">");
               out.print("</tr>");

                }
                out.print("</table>");