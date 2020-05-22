DiagramController
{
  public DiagramController(diagramBuilder:DiagramBuilder)
  {
    this._diagramBuilder = diagramBuilder;
    this._commandStack = new Stack();
  }

  public void Add(node:ConditionalNode)
  {
    string graphicalRefId = this._diagramBuilder.Draw(node);
    var nodePair = new KeyValuePair<string, ConditionalNode> (graphicalRefId, node);
    this._commandStack.push(nodePair);
  }

  public void Undo()
  {
    var nodePair = this._commandStack.pop();
    this._diagramBuilderUndraw(nodePair.Key);
  }
}