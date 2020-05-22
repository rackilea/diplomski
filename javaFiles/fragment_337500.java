DiagramController
{
  public DiagramController(diagramBuilder:DiagramBuilder)
  {
    this._diagramBuilder = diagramBuilder;
    this._commandStack = new Stack();
  }

  public void Add(node:ConditionalNode)
  {
    this._commandStack.push(node);
    this._diagramBuilder.Draw(node);
  }

  public void Undo()
  {
    var node = this._commandStack.pop();
    this._diagramBuilderUndraw(node);
  }
}