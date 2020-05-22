public class Mouse extends Animal <MouseWalkData>{
    @Override
    void walk(MouseWalkData mouseWalkData) {
        System.out.println(mouseWalkData.getWalkSound());
        System.out.println(mouseWalkData.getWalkSpeed());
        System.out.println(mouseWalkData.getMouseSpecific());

    }
}