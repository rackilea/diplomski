[TestFixture]
class Program
{
    [Test]
    [UseReporter(typeof(WinMergeReporter))]
    public void Test1()
    {
        var image1 = @"firstImage.png";
        var image2 = @"secondImage.png";

        NamerFactory.AdditionalInformation = Path.GetFileNameWithoutExtension(image1);
        ApprovalTests.Approvals.Verify(image1);

        NamerFactory.AdditionalInformation = Path.GetFileNameWithoutExtension(image2);
        ApprovalTests.Approvals.Verify(image2);
    }
}