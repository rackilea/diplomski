public ArrayList<QuakeEntry>getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    int bigIndex = indexOfLargest(quakeData);
    answer.add(quakeData.get(bigIndex));

    return answer;
}