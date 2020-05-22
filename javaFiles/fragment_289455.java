private void setAdapterToDisplayStats(int positionToUpdate) {

    apt_confirmedPlayers.clear();
    apt_confirmedPlayers.addAll(ATC_PlayerInfo.createPlayersList(confirmedPlayers,numToHit, amountHit, amountThrown));
    adapter.notifyItemChanged(positionToUpdate);
}