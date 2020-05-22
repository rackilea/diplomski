// Rotating around these axes in sequence will bring each face in turn
// to the top
private static GameObject.AXIS ROTATION_PATH = new GameObject.AXIS[] {
    GameObject.AXIS.X_AXIS,
    GameObject.AXIS.X_AXIS,
    GameObject.AXIS.Z_AXIS,
    GameObject.AXIS.X_AXIS,
    GameObject.AXIS.X_AXIS,
    GameObject.AXIS.Z_AXIS
};

public static int getPossibleSolutionCount(Map<PieceIndex, Piece> pieces)
{
    int count = 0;
    for (GameObject.AXIS path_axis: ROTATION_PATH)
    {
        for (int y = 0; y < 4; y++)
        {
            for (Solution s : solutions)
            {
               if (s.isDerivedFrom(pieces))
               {
                   count++;
               }
            }
            pieces.values().forEach(piece -> piece.rotate(GameObject.Axis.Y_AXIS));
        }
        pieces.values().forEach(piece -> piece.rotate(path_axis));
    }
    return count;
}