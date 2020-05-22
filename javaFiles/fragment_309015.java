Standings standings = (Standings)this.getItem( position );
    standingsHolder.tx_id.setText( Integer.toString(standings.getDriver_id()) );
    standingsHolder.txt_id.setText(Integer.toString(standings.getTeam_id()));
    standingsHolder.tx_fn.setText( standings.getFirstName() );
    standingsHolder.tx_ln.setText( standings.getLastName() );
    standingsHolder.tx_pos.setText(Integer.toString(standings.getPosition()));
    standingsHolder.tx_po.setText(Integer.toString(standings.getPoints()));