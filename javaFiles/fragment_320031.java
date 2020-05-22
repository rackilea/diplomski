public class TileSets
{   
 private Game game;

 public TileSets(Game game)
 {
 this.game = game;
 }

 public void Terrain()
 {
 GameObject Tile0 = new GameObject();
 Mesh mesh = new Mesh("Tile1.obj");
 Material material = new Material
 (new Texture("GrassUV.png"), 1, 8);
 MeshRenderer meshRenderer = new MeshRenderer(mesh, material);
 Tile0.AddComponent(meshRenderer);
 Tile0.GetTransform().GetPos().Set(0, 0, 0);
 game.AddObject(Tile0); 
 }
}