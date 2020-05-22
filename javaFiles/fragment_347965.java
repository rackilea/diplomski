Set<Integer> medicalSignsSymptomIdList = medicalInfoVO.getMedicalSignsSymptoms().stream()
            .map(mSSymptoms -> {
                Integer id = mSSymptoms.getMedicalSignsSymptomId();
                mSSymptoms.setMedicalSignsSymptomId(null);
                mSSymptoms.setMedicalInfoId(null);
                return id;
            }) 
            .collect(Collectors.toSet());