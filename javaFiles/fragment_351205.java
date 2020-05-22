Atlas atlas;
Iterable<ComplexWaterEntity> waterEntities =
    new ComplexWaterEntityFinder().find(atlas);

// Get all water bodies and keep lakes only.
// This will include the multipolygon ones.
Iterable<ComplexWaterBody> lakes = Iterables.stream(waterEntities)
    .filter(entity -> WaterType.LAKE == entity.getWaterType())
    .map(entity -> (ComplexWaterBody) entity);

// Add all the surface areas
Surface result = Surface.MINIMUM;
for (ComplexWaterBody lake : lakes)
{
    result = result.add(lake.getGeometry().getSurface()));
}
System.out.println(result.asKilometerSquared());