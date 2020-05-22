public class MeasurementUnit(){ 
      ...
          private String name = "test";
          private List<MeasurementPoint> measPoints;

          for(MeasurementPoint measPoint:measPoints){

         someOtherMethod(measPoint.getXXX(), measPoint.getYYYY(),name);

       }
    }