import gov.nasa.worldwind.layers.SurfaceImageLayer;
import gov.nasa.worldwind.render.AbstractSurfaceObject;
import gov.nasa.worldwind.render.Renderable;

/**
 * Very Rough extension of SurfaceImageLayer which disables batch picking on all AbstractSurfaceobjects.
 * @author http://stackoverflow.com/users/5407189/jeremiah
 * @since Nov 26, 2016
 *
 */
public class MySurfaceImageLayer extends SurfaceImageLayer {


    @Override
    public void addRenderable(Renderable renderable) {
      if (renderable instanceof AbstractSurfaceObject) {
          ((AbstractSurfaceObject)renderable).setEnableBatchPicking(false);
      }
      super.addRenderable(renderable);
    }

    @Override
    public void addRenderables(Iterable<? extends Renderable> renderables) {
       for (Renderable r : renderables) {
           addRenderable(r);
       }
    }
}