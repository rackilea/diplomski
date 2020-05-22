/**Mention only the folder/file under the asset dir**/

public class Gameconstants { public static final String location = "packed/packed.txt" }

/**access the same using the following command**/

private AssetManager assetManager;
assetManager.load(Gameconstants.location,Texture.class);