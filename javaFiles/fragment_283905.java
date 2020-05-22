public class TreeDataCell extends TreeCell<TreeData> {

    @Override
    protected Skin<?> createDefaultSkin() {
        TreeCellSkin<?> skin = (TreeCellSkin<?>) super.createDefaultSkin();
        skin.setIndent(/* your value */);
        return skin;
    }

}