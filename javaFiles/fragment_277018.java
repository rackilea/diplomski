<tbody>
    @for(ticket <- obj.getPurchasedTickets()) {
        @for((key, value) <- obj.getTicketsCalculation()) {
            @if(key.equals(ticket.getTicketId())) {
                <tr>
                    <td class="desc">@ticket.getTicketName()<br></br>
                        @if(ticket.getTicketIds() != null && !ticket.getTicketIds().isEmpty()) {
                            @for(ticketid <- ticket.getTicketIds){
                                #@ticketid
                            }
                        }
                    </td>
                    <td class="unit">@ticket.getPrice()</td>
                </tr>
            }
        }
    }
</tbody>