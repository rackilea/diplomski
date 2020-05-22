@override
Widget build(BuildContext context) {
  return Column(
    children: <Widget>[
      Flexible(child: Card(child: _buildAssegnoList(context)))
    ],
  );
}