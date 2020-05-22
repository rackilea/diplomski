private Double getCalibrationFactor(String sensorId,
                                    Field<Double> factor,
                                    Table<?> PM,
                                    Field<Integer> sensorIdTableField,
                                    Field<Timestamp> timeFromWhichFactorIsUsed) {
  Record1<Double> calibrationFactorAPM1 = Database.create
              .select(factor) //CalibrationFactorPm1.CALIBRATION_FACTOR_PM1.FACTOR_A
              .from(PM) //CalibrationFactorPm1.CALIBRATION_FACTOR_PM1
              .where(sensorIdTableField.equal(Integer.valueOf(sensorId)))
              .orderBy(timeFromWhichFactorIsUsed.desc())
              .fetchOne();
  return calibrationFactorAPM1 == null ? calibrationFactorAPM1.value1() : 1d;
}