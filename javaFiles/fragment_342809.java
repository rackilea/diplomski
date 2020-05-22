boolean found = false;
for (int i = 0; i < chestsUsedTileRowsArray.length; i++) {
    if (chestFoundTileRow == chestsUsedTileRowsArray[i] && chestFoundTileColumn == chestsUsedTileColumnsArray[i]) {
        found = true;
        break;
    }
}
if (!found) {
    rewardPlayer();
    saveChestUsed(tileRow, tileColumn);
}