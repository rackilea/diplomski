LinkedList<Point> queryList = new LinkedList<Point>();
LinkedList<Point> trainList = new LinkedList<Point>();

List<KeyPoint> keypoints_queryList = keyPoints1.toList();
List<KeyPoint> keypoints_trainList = keyPoints2.toList();

for (int i = 0; i < bestMatches.size(); i++) {
   queryList.addLast(keypoints_queryList.get(bestMatches.get(i).queryIdx).pt);
   trainList.addLast(keypoints_trainList.get(bestMatches.get(i).trainIdx).pt);
}


MatOfPoint2f queryCoords = new MatOfPoint2f();
queryCoords.fromList(queryList);

MatOfPoint2f trainCoords = new MatOfPoint2f();
trainCoords.fromList(trainList);