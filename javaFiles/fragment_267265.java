package serialize2d;

import java.awt.Shape;
import java.beans.*;
import java.io.*;
import java.util.ArrayList;

public class ShapeIO {

    /** Save the list of shapes to the file system. */
    public static void serializeShapes(
            ArrayList<Shape> shapes, Class serializeClass) 
            throws FileNotFoundException {
        File f = getSerializeFile(serializeClass);
        XMLEncoder xmle = new XMLEncoder(new FileOutputStream(f));

        ArrayList<PathBean> pathSegmentsCollection = new ArrayList<>();
        for (Shape shape : shapes) {
            ArrayList<PathSegment> pathSegments = 
                    BeanConverter.getSegmentsFromShape(shape);
            PathBean as = new PathBean(pathSegments);
            pathSegmentsCollection.add(as);
        }

        xmle.writeObject(pathSegmentsCollection);
        xmle.flush();
        xmle.close();
    }

    /** Load the list of shapes from the file system. */
    public static ArrayList<Shape> deserializeShapes(Class serializeClass) 
            throws FileNotFoundException {
        File f = getSerializeFile(serializeClass);
        XMLDecoder xmld = new XMLDecoder(new FileInputStream(f));
        ArrayList<PathBean> pathSegmentsCollection
                = (ArrayList<PathBean>) xmld.readObject();
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        for (PathBean pathSegments : pathSegmentsCollection) {
            shapes.add(BeanConverter.getShapeFromSegments(pathSegments));
        }

        return shapes;
    }

    /** Provide an unique, reproducible & readable/writable path for a class. */
    public static File getSerializeFile(Class serializeClass) {
        File f = new File(System.getProperty("user.home"));
        String[] nameParts = serializeClass.getCanonicalName().split("\\.");

        f = new File(f, "java");
        for (String namePart : nameParts) {
            f = new File(f, namePart);
        }
        f.mkdirs();
        f = new File(f, nameParts[nameParts.length-1] + ".xml");

        return f;
    }
}