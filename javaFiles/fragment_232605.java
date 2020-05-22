Player(int startPos, int startHP)
{
    playerPos = startPos;
    playerHP = startHP;
    playerInv = new String[10];
    Arrays.fill(playerInv, "");
}