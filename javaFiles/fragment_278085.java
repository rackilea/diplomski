public void checkIfTimesOverlapped(){


// eft - existed FROM TIME
// ett - existed TO TIME
// cft - current entered FROM TIME
// ctt - current entered TO TIME
// Note : same FROM TIME and TO TIME is not allowed. so not checking. 

float eft = 22.00f; 
float ett = 05.00f;
float cft = 23.00f;
float ctt = 24.00f;


    if (cft < ctt) {
        if (eft < ett) {
            if(cft<=ett && ctt>=eft){
                System.out.println("overlapped");
            }

        } else if(eft > ett) {
            if(!(cft>ett && ctt<eft)){
                System.out.println("overlapped");
            }
        }
    } else if (cft > ctt) {

        if (eft < ett) {
            if((cft>=eft && cft<=ett) || (ctt>=eft && ctt<=ett)){
                System.out.println("overlapped");
            }

        } else if(eft > ett) {
            // already one shift existed with FROM TIME > TO TIME. so again FROM TIME > TO TIME is not possible
            System.out.println("overlapped");
        }

    }