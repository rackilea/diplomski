@Override
public void dispose()
{
    anotherPage.someButton.removeSelectionListener(this);

    super.dispose();
}