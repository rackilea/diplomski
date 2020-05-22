import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Application extends QWidget {

    public Application() {

        setWindowTitle("Simple Example");
        setMinimumHeight(100);
        setMinimumWidth(100);
        setGeometry(250, 250, 350, 100);

        initUI();

        show();
    }

    private void initUI() {

        QHBoxLayout main_layout = new QHBoxLayout(this);

        QPushButton new_action = new QPushButton("Working");
        new_action.released.connect(this,"Tata()");
        main_layout.addWidget(new_action);

    }

    private void Tata(){
        System.out.println("Yes, it's Working");
    }

    public static void main(String[] args) {
        QApplication.initialize(args);
        new Application();
        QApplication.execStatic();
        QApplication.shutdown();
    }
}