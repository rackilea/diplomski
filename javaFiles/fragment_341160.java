public static Coordinate coordinate(TangoPoseData pose){

    return new Coordinate(pose.translation[TangoPoseData.INDEX_TRANSLATION_X],
                pose.translation[TangoPoseData.INDEX_TRANSLATION_Y],
                pose.translation[TangoPoseData.INDEX_TRANSLATION_Z]);
}