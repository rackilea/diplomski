for (int i = 0; i < CalculateActivity.this.coursesList.size() && i <CalculateActivity.this.gradesList.size(); i++) {
            int crdtHrs = ((Course) CalculateActivity.this.coursesList.get(i)).getCreditHours();
            totalCrdtHrs += (float) crdtHrs;
            averageGrade += (((Float)CalculateActivity.this.gradesList.get(i).floatValue())*(((Course) CalculateActivity.this.coursesList.get(i)).getCreditHours())/totalCrdtHrs);

        }