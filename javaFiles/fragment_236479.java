/**
 * Walks the decorator hierarchy recursively from the outside in (excluding the final
 * IMeasureSensor which is not a ISensorDecorator), and returns the decorator of the given class.
 * If none can be found, null is returned.
 */
IMeasureSensor findDecorator(IMeasureSensor sensor, Class decoratorClass){
    if( ISensorDecorator.class.isAssignableFrom(sensor.getClass()) ){
        return (sensor.getClass() == decoratorClass) 
            ? sensor 
            : findDecorator(((ISensorDecorator) sensor).getDecoratee(), decoratorClass);
    } 
    else
        return null;
}