import javax.swing.*
import javax.swing.tree.*

class Root {
    def attributes = []
    def children = []
    def value = 0

    def String toString() { 
        "[${value}] attributes: ${attributes} children: ${children}" 
    }
}

def createTreeNode(node) {
    def top = new DefaultMutableTreeNode(node.value)
    for (attr in node.attributes) {
        top.add(new DefaultMutableTreeNode(attr))
    }
    for (child in node.children) {
        top.add(createTreeNode(child))
    }   
    top
}

root = new Root(
    attributes: ['rootattribute1', 'rootattribute2'], 
    value: 100,
    children: [
        new Root(
            attributes: ['childNode2att1'],
            value: 1001),
        new Root(
            attributes: ['childNode2attributes'],
            value: 1002),    
    ])


frame = new JFrame('Tree Test')
frame.setSize(300, 300)
frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
jtree = new JTree(createTreeNode(root))
frame.add(jtree)
frame.show()