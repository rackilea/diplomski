public String toString() {
  StringBuffer sb = new StringBuffer();
   for(int card = 0; card < 4; card++)
        {
            sb.append(hand[card]+",")
        }
  return sb.toString()
}